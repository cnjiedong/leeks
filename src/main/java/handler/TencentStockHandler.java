package handler;

import org.apache.commons.lang3.StringUtils;
import bean.StockBean;
import utils.HttpClientPool;
import utils.LogUtil;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

public class TencentStockHandler extends StockRefreshHandler {
    private String urlPara;

    private Thread worker;
    private JLabel refreshTimeLabel;


    public TencentStockHandler(JTable table1, JLabel refreshTimeLabel) {
        super(table1);
        this.refreshTimeLabel = refreshTimeLabel;
    }

    @Override
    public void handle(List<String> code) {

        if (worker!=null){
            worker.interrupt();
        }
        LogUtil.info("Leeks 更新Stock编码数据.");
//        clearRow();
        if (code.isEmpty()){
            return;
        }
        worker = new Thread(new Runnable() {
            @Override
            public void run() {
                while (worker!=null && worker.hashCode() == Thread.currentThread().hashCode() && !worker.isInterrupted()){
                    stepAction();
                    try {
                        Thread.sleep(threadSleepTime * 1000);
                    } catch (InterruptedException e) {
                        LogUtil.info("Leeks 已停止更新Stock编码数据.");
                        refreshTimeLabel.setText("stop");
                        return;
                    }
                }
            }
        });
        urlPara = String.join(",", code);
        worker.start();

    }

    @Override
    public void stopHandle() {
        if (worker != null) {
            worker.interrupt();
            LogUtil.info("Leeks 准备停止更新Stock编码数据.");
        }
    }

    private void stepAction() {
//        Date now = new Date();
//        if ( now.getHours() < 9 || now.getHours() > 16){//九点到下午4点才更新数据
//            try {
//                Thread.sleep(60 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return;
//        }
        if (StringUtils.isEmpty(urlPara)){
            return;
        }
        try {
            String result = HttpClientPool.getHttpClient().get("http://qt.gtimg.cn/q="+urlPara);
            parse(result);
            updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parse(String result) {
        String[] lines = result.split("\n");
        for (String line : lines) {
            String code = line.substring(line.indexOf("_")+1,line.indexOf("="));
            String dataStr = line.substring(line.indexOf("=")+2,line.length()-2);
            String[] values = dataStr.split("~");
            StockBean bean = new StockBean(code);
            bean.setName(values[1]);
            bean.setNow(values[3]);
            bean.setChange(values[31]);
            bean.setChangePercent(values[32]);
            bean.setTime(values[30]);
            bean.setMax(values[33]);//33
            bean.setMin(values[34]);//34
            bean.setExchange(values[39]);

            bean.setBuy1( values[10]);
            bean.setBuy2( values[12]);
            bean.setBuy3( values[14]);
            bean.setBuy4( values[16]);
            bean.setBuy5( values[18]);

            bean.setSell1( values[20]);
            bean.setSell2( values[22]);
            bean.setSell3( values[24]);
            bean.setSell4( values[26]);
            bean.setSell5( values[28]);

            bean.setBuyPrice1(values[9] );
            bean.setBuyPrice2(values[11]) ;
            bean.setBuyPrice3(values[13]) ;
            bean.setBuyPrice4(values[15]) ;
            bean.setBuyPrice5(values[17]) ;

            bean.setSellPrice1(values[19]);
            bean.setSellPrice2(values[21]);
            bean.setSellPrice3(values[23]);
            bean.setSellPrice4(values[25]);
            bean.setSellPrice5(values[27]);

            updateData(bean);
        }
    }

    public void updateUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                refreshTimeLabel.setText(LocalDateTime.now().format(TianTianFundHandler.timeFormatter));
                refreshTimeLabel.setToolTipText("最后刷新时间，刷新间隔" + threadSleepTime + "秒");
            }
        });
    }


}

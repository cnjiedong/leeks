package bean;

import utils.PinYinUtils;

import java.util.Objects;

public class StockBean {
    private String code;
    private String name;
    private String now;
    private String change;//涨跌
    private String changePercent;
    private String time;
    /**
     * 最高价
     */
    private String max;
    /**
     * 最低价
     */
    private String min;
    /**
     * 换手率
     */
    private String exchange;

    private String buyPrice1;
    private String buyPrice2;
    private String buyPrice3;
    private String buyPrice4;
    private String buyPrice5;
    private String sellPrice1;
    private String sellPrice2;
    private String sellPrice3;
    private String sellPrice4;
    private String sellPrice5;

    private String buy1;
    private String buy2;
    private String buy3;
    private String buy4;
    private String buy5;
    private String sell1;
    private String sell2;
    private String sell3;
    private String sell4;
    private String sell5;

    public StockBean() {
    }

    public StockBean(String code) {
        this.code = code;
        this.name = "--";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getBuy1() {
        return buy1;
    }

    public void setBuy1(String buy1) {
        this.buy1 = buy1;
    }

    public String getBuy2() {
        return buy2;
    }

    public void setBuy2(String buy2) {
        this.buy2 = buy2;
    }

    public String getBuy3() {
        return buy3;
    }

    public void setBuy3(String buy3) {
        this.buy3 = buy3;
    }

    public String getBuy4() {
        return buy4;
    }

    public void setBuy4(String buy4) {
        this.buy4 = buy4;
    }

    public String getBuy5() {
        return buy5;
    }

    public void setBuy5(String buy5) {
        this.buy5 = buy5;
    }

    public String getSell1() {
        return sell1;
    }

    public void setSell1(String sell1) {
        this.sell1 = sell1;
    }

    public String getSell2() {
        return sell2;
    }

    public void setSell2(String sell2) {
        this.sell2 = sell2;
    }

    public String getSell3() {
        return sell3;
    }

    public void setSell3(String sell3) {
        this.sell3 = sell3;
    }

    public String getSell4() {
        return sell4;
    }

    public void setSell4(String sell4) {
        this.sell4 = sell4;
    }

    public String getSell5() {
        return sell5;
    }

    public void setSell5(String sell5) {
        this.sell5 = sell5;
    }

    public String getBuyPrice1() {
        return buyPrice1;
    }

    public void setBuyPrice1(String buyPrice1) {
        this.buyPrice1 = buyPrice1;
    }

    public String getBuyPrice2() {
        return buyPrice2;
    }

    public void setBuyPrice2(String buyPrice2) {
        this.buyPrice2 = buyPrice2;
    }

    public String getBuyPrice3() {
        return buyPrice3;
    }

    public void setBuyPrice3(String buyPrice3) {
        this.buyPrice3 = buyPrice3;
    }

    public String getBuyPrice4() {
        return buyPrice4;
    }

    public void setBuyPrice4(String buyPrice4) {
        this.buyPrice4 = buyPrice4;
    }

    public String getBuyPrice5() {
        return buyPrice5;
    }

    public void setBuyPrice5(String buyPrice5) {
        this.buyPrice5 = buyPrice5;
    }

    public String getSellPrice1() {
        return sellPrice1;
    }

    public void setSellPrice1(String sellPrice1) {
        this.sellPrice1 = sellPrice1;
    }

    public String getSellPrice2() {
        return sellPrice2;
    }

    public void setSellPrice2(String sellPrice2) {
        this.sellPrice2 = sellPrice2;
    }

    public String getSellPrice3() {
        return sellPrice3;
    }

    public void setSellPrice3(String sellPrice3) {
        this.sellPrice3 = sellPrice3;
    }

    public String getSellPrice4() {
        return sellPrice4;
    }

    public void setSellPrice4(String sellPrice4) {
        this.sellPrice4 = sellPrice4;
    }

    public String getSellPrice5() {
        return sellPrice5;
    }

    public void setSellPrice5(String sellPrice5) {
        this.sellPrice5 = sellPrice5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockBean bean = (StockBean) o;
        return Objects.equals(code, bean.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }


    /**
     * 返回列名的VALUE 用作展示
     * @param colums 字段名
     * @param colorful 隐蔽模式
     * @return 对应列名的VALUE值 无法匹配返回""
     */
    public String getValueByColumn(String colums, boolean colorful) {
        switch (colums) {
            case "编码":
                return this.getCode();
            case "股票名称":
                return colorful ? this.getName() : PinYinUtils.toPinYin(this.getName());
            case "当前价":
                return this.getNow();
            case "涨跌":
                String changeStr = "--";
                if (this.getChange() != null) {
                    changeStr = this.getChange().startsWith("-") ? this.getChange() : "+" + this.getChange();
                }
                return changeStr;
            case "最高涨幅":

                return "1";
            case "最低跌幅":
                return "1";
                /*String changePercentStr = "--";
                if (this.getChangePercent() != null) {
                    changePercentStr = this.getChangePercent().startsWith("-") ? this.getChangePercent() : "+" + this.getChangePercent();
                }
                return changePercentStr + "%";*/
            case "最高价":
                return this.getMax();
            case "最低价":
                return this.getMin() ;
            case "换手率":
                return this.getExchange() ;
            case "更新时间":
                String timeStr = "--";
                if (this.getTime() != null) {
                    timeStr = this.getTime().substring(8);
                }
                return timeStr;
            case "买一":
                return this.getBuy1() ;
            case "买二":
                return this.getBuy2() ;
            case "买三":
                return this.getBuy3() ;
            case "买四":
                return this.getBuy4() ;
            case "买五":
                return this.getBuy5() ;
            case "卖一":
                return this.getSell1() ;
            case "卖二":
                return this.getSell2() ;
            case "卖三":
                return this.getSell3() ;
            case "卖四":
                return this.getSell4() ;
            case "卖五":
                return this.getSell5() ;
            case "买一价":
                return this.getBuyPrice1() ;
            case "买二价":
                return this.getBuyPrice2() ;
            case "买三价":
                return this.getBuyPrice3() ;
            case "买四价":
                return this.getBuyPrice4() ;
            case "买五价":
                return this.getBuyPrice5() ;
            case "卖一价":
                return this.getSellPrice1() ;
            case "卖二价":
                return this.getSellPrice2() ;
            case "卖三价":
                return this.getSellPrice3() ;
            case "卖四价":
                return this.getSellPrice4() ;
            case "卖五价":
                return this.getSellPrice5() ;
            default:
                return "";

        }
    }
}

package main.java.model;

public class TemplateResponce {

    private String formAddClientTemplate = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/styles/styles.css\"/>" +
            "</head><body><fieldset><div id=\"logo\"><u>MANAGEMENT INTERFACE</u><p>add new client interface</p></div>" +
            "<div id=\"content\"><form action=\"/new_client\" method=\"post\"><input type=\"text\" name=\"name\"" +
            "placeholder=\"input name\"/><input type=\"text\" name=\"address\" placeholder=\"input address\"/>" +
            "<input type=\"text\" name=\"phone\" placeholder=\"input phone number\"/>" +
            "<br><br><input type=\"submit\" value=\"add this client\"></form></div></fieldset></body></html>";

    private String formAddGoodsTemplate = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/styles/styles.css\"/>" +
            "</head><body><fieldset><div id=\"logo\"><u>MANAGEMENT INTERFACE</u><p>add new goods interface</p></div>" +
            "<div id=\"content\"><form action=\"/new_goods\" method=\"post\"><input type=\"text\" name=\"brand\"" +
            "placeholder=\"input brand\"/><br><input type=\"text\" name=\"model\" placeholder=\"input model\"/>" +
            "<br><input type=\"number\" name=\"price\" placeholder=\"input price\"/>" +
            "<br><input type=\"number\" name=\"quantity\" placeholder=\"input quantity\"/>" +
            "<br><br><input type=\"submit\" value=\"add to stockroom\"></form></div></fieldset></body></html>";

    private String formNewOrderTemplate = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/styles/styles.css\"/>" +
            "</head><body><fieldset><div id=\"logo\"><u>MANAGEMENT INTERFACE</u><p>add new order interface</p></div>" +
            "<div id=\"content\"><form action=\"/new_order\" method=\"post\"><input type=\"text\" name=\"goods\"" +
            "placeholder=\"input goods\"/><input type=\"text\" name=\"client\" placeholder=\"input client\"/>" +
            "<input type=\"number\" name=\"quentity\" placeholder=\"input quentity\"/>" +
            "<br><br><input type=\"submit\" value=\"do it\"></form></div></fieldset></body></html>";

    private String stockroomTemplate = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/styles/styles.css\"/>" +
            "</head><body><fieldset><div id=\"logo\"><u>MANAGEMENT INTERFACE</u><p>stockroom</p></div>" +
            "<div id=\"content\">%s</div></fieldset></body></html>";

    public TemplateResponce() {
    }

    public String getFormAddClientTemplate() {
        return formAddClientTemplate;
    }

    public void setFormAddClientTemplate(String formAddClientTemplate) {
        this.formAddClientTemplate = formAddClientTemplate;
    }

    public String getFormAddGoodsTemplate() {
        return formAddGoodsTemplate;
    }

    public void setFormAddGoodsTemplate(String formAddGoodsTemplate) {
        this.formAddGoodsTemplate = formAddGoodsTemplate;
    }

    public String getFormNewOrderTemplate() {
        return formNewOrderTemplate;
    }

    public void setFormNewOrderTemplate(String formNewOrderTemplate) {
        this.formNewOrderTemplate = formNewOrderTemplate;
    }

}

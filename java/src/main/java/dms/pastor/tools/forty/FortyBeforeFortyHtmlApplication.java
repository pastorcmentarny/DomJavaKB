package dms.pastor.tools.forty;

public class FortyBeforeFortyHtmlApplication {

    public static void main(String[] args) {
        HtmlGenerator html = new HtmlGenerator();
        System.out.println(html.generate());
        System.out.println(html.saveAsHtml());
    }
}

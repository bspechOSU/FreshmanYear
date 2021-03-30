import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to convert an XML RSS (version 2.0) feed from a given URL into the
 * corresponding HTML output file.
 *
 * @author robert spech.111 https://news.yahoo.com/rss/
 *
 */
public final class RSSAggregator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSAggregator() {
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of type tag of the {@code XMLTree}
     *         or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures <pre>
     * getChildElement =
     *  [the index of the first child of type tag of the {@code XMLTree} or
     *   -1 if not found]
     * </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";

        int location = -1;
        int count = 0;
        while (count < xml.numberOfChildren()) {
            // runs through each child
            if (xml.child(count).label().equals(tag)) {
                location = count;
            }
            count++;
        }
        return location;
        // returns the location of the child element if it is present

    }

    /**
     * Processes one news item and outputs one table row. The row contains three
     * elements: the publication date, the source, and the title (or
     * description) of the item.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the label of the root of item is an <item> tag] and
     *           out.is_open
     * @ensures <pre>
     * out.content = #out.content *
     *   [an HTML table row with publication date, source, and title of news item]
     * </pre>
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        String linkLink = "No source available";
        String linkTitle = "No title available";
        String description = "No desc available";
        String pubDate = "No date available";
        String source = "Source";
        String titleSource = "Source";
        // starts the variables off with Nothing in case an element isn't present
        out.println("<tr>");

        if ((item.child(getChildElement(item, "pubDate"))
                .numberOfChildren() > 0)) {
            // if there is a pubDate with a child, this loop will enter
            pubDate = item.child(getChildElement(item, "pubDate")).child(0)
                    .label();
            out.println("<td>" + pubDate + "</td>");
            // this prints out the date in HTML format
        } else {
            // if there is no date child, No date will be printed
            out.println("<td>" + pubDate + "</td>");
        }

        if (((getChildElement(item, "source")) > -1) && item
                .child(getChildElement(item, "source")).hasAttribute("url")) {
            // if there is an element with an attribute url, this is entered
            linkLink = item.child(getChildElement(item, "source"))
                    .attributeValue("url");
            // finds the link
            source = item.child(getChildElement(item, "source")).child(0)
                    .label();
            // gets the source
            out.println(
                    "<td> <a href =" + linkLink + ">" + source + " </a> </td>");
            // prints out the source in a hyperlink
        } else {
            // if there is no url attribute, the print statement will show no source
            out.println("<td> " + linkLink + "</td>");
        }

        if ((getChildElement(item, "title") > -1) && item
                .child(getChildElement(item, "title")).numberOfChildren() > 0) {
            // this branch is entered if there is a title child with a child
            linkTitle = item.child(getChildElement(item, "title")).child(0)
                    .label();
            if (item.child(getChildElement(item, "link"))
                    .numberOfChildren() > 0) {
                // if there is a link tag with a child, this branch is entered
                titleSource = item.child(getChildElement(item, "link")).child(0)
                        .label();
                out.println("<td> <a href =" + titleSource + ">" + linkTitle
                        + " </a> </td>");
            } else {
                // if there isn't a link available, only the title will be printed
                out.println("<td> " + linkTitle + " </td>");
            }

        } else if (((getChildElement(item, "description") > -1))
                && item.child(getChildElement(item, "description"))
                        .numberOfChildren() > 0) {
            // this branch is entered only if there is no title and there is a description
            int i = 0;
            while (i < item.child(getChildElement(item, "description"))
                    .numberOfChildren()) {
                // this loop will run through the children of description
                if (!item.child(getChildElement(item, "description")).child(i)
                        .isTag()) {
                    // if its not a tag, its the actual description
                    description = item
                            .child(getChildElement(item, "description"))
                            .child(i).label();
                    if (item.child(getChildElement(item, "link"))
                            .numberOfChildren() > 0) {
                        // if there is a link tag with a child, this branch is entered
                        titleSource = item.child(getChildElement(item, "link"))
                                .child(0).label();
                        out.println("<td> <a href =" + titleSource + ">"
                                + description + "</a> </td>");
                        // if there is a link available, it will be hyperlinked
                    } else {
                        // if there isn't a link, only the description will be printed
                        out.println("<td>" + description + "</td>");
                    }
                    i = item.child(getChildElement(item, "description"))
                            .numberOfChildren();
                }
                i++;
            }
        } else {
            // if there is no title or description, this branch will be entered
            if (item.child(getChildElement(item, "link"))
                    .numberOfChildren() > 0) {
                // if there is a link tag with a child, this branch is entered
                titleSource = item.child(getChildElement(item, "link")).child(0)
                        .label();
                out.println("<td> <a href =" + titleSource + ">" + description
                        + "</a> </td>");
                // this prints out No title but with a source
            } else {
                // if there is absolutely nothing, it will be indicated
                out.println("<td>" + linkTitle + "</td>");
            }
        }

        out.println("</tr>");

    }

    /**
     *
     * THis method will test whether or not an xml document is valid.
     *
     * @param xml
     *            file given to check
     * @return returns a boolean if the xml tree is valid or invalid
     * @requires an xml document as input
     * @ensures boolean is tru if valid or false if invalid
     */

    private static boolean htmlCheck(XMLTree xml) {
        boolean valid = false;
        if (xml.attributeValue("version").equals("2.0")
                && xml.label().equals("rss")) {
            valid = true;
        }
        return valid;
    }

    /**
     * Processes one XML RSS (version 2.0) feed from a given URL converting it
     * into the corresponding HTML output file.
     *
     * @param url
     *            the URL of the RSS feed
     * @param file
     *            the name of the HTML output file
     * @param out
     *            the output stream to report progress or errors
     * @updates out.content
     * @requires out.is_open
     * @ensures <pre>
     * [reads RSS feed from url, saves HTML document with table of news items
     *   to file, appends to out.content any needed messages]
     * </pre>
     */
    private static void processFeed(String url, String file, SimpleWriter out) {
        XMLTree main = new XMLTree1(url);
        if (htmlCheck(main)) {
            XMLTree channel = main.child(0);
            SimpleWriter outFileTwo = new SimpleWriter1L(file);

            String mainTitle = "Empty Title";
            // creates the main title variable

            outFileTwo.println("<html> <head> <title>");
            // prints out the basic HTML Headings
            if (channel.child(getChildElement(channel, "title"))
                    .numberOfChildren() > 0) {
                mainTitle = channel.child(getChildElement(channel, "title"))
                        .child(0).label();

            }
            // starts printing the basic header information required
            outFileTwo.println(mainTitle + "</title>");
            outFileTwo.println("</head> <body>");
            // closes the basic header and starts the body
            //prints the title in html format

            String urlTwo = channel.child(getChildElement(channel, "link"))
                    .child(0).label();
            outFileTwo.println("<h1> <a href =" + urlTwo + "> " + mainTitle
                    + " </a> </h1>");
            outFileTwo.println("<p>");
            // makes the url linked in the Title
            String channelDesc = "No Description";
            if (channel.child(getChildElement(channel, "description"))
                    .numberOfChildren() > 0) {
                channelDesc = channel
                        .child(getChildElement(channel, "description")).child(0)
                        .label();
            }
            outFileTwo.println(channelDesc);
            // prints the description if its present
            outFileTwo.println("</p>");
            outFileTwo.println("<table border=\"1\">");
            outFileTwo.println("<tr>");
            outFileTwo.println("<th>Date</th>");
            outFileTwo.println("<th>Source</th>");
            outFileTwo.println("<th>News</th>");
            // starts the table and adds the table headings
            int countThree = 0;
            // this loop will process each instance of an item child
            while (countThree < channel.numberOfChildren()) {
                if (channel.child(countThree).label().equals("item")) {
                    processItem(channel.child(countThree), outFileTwo);
                }
                countThree++;
            }

            // this is where i need to process all of item

            outFileTwo.println("</table>");
            outFileTwo.println("</body> </html>");
            // prints the three basic closing tags.
            outFileTwo.close();
        } else {
            out.println("One Document was Invalid");
        }

    }

    /**
     * Main method. The main method will take in an rss document, create an xml
     * tree and output a file of format html
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        boolean validXML = false;
        out.print("Enter an RSS 2.0 news feed or related url: ");
        String input = in.nextLine();
        XMLTree xml = new XMLTree1(input);
        // creates an xml tree
        while (!validXML) {
            // this loop will determine whether or not the input document was valid
            if (xml.hasAttribute("title")) {
                validXML = true;
            } else {
                // if the document is not valid, it will ask again and create a new tree
                out.print("Enter an RSS 2.0 news feed or related url: ");
                input = in.nextLine();
                xml = new XMLTree1(input);
            }
        }

        boolean validFileName = false;
        String fileName = "";
        // this ensures the user adds .html to the filename
        while (!validFileName) {
            out.print(
                    "Enter a file name for the main output file, include .html: ");
            fileName = in.nextLine();
            final int htmlLength = 5;
            if (fileName.length() > htmlLength
                    && fileName.substring(fileName.length() - htmlLength,
                            fileName.length()).equals(".html")) {
                // if .html isn't the last part of the file, it will ask again
                validFileName = true;
            } else {
                out.println("Enter a valid html file name.");
            }
        }

        SimpleWriter outFile = new SimpleWriter1L(fileName);
        // This creates a new output stream for the file created

        // prints the Title for the main Index HTML Page
        String mainTitle = "Empty Title";
        outFile.println("<html> <head> <title>");
        mainTitle = xml.attributeValue("title");

        // starts printing the basic header information required
        outFile.println(mainTitle + "</title>");
        outFile.println("</head> <body>");

        outFile.println("<h1>" + mainTitle + "</h1>");
        // prints out the main headings for the index doc

        int count = 0;
        outFile.println("<ul>");
        while (count < xml.numberOfChildren()) {
            // runs through the children of Feeds
            String url = xml.child(count).attributeValue("url");
            String file = xml.child(count).attributeValue("file");
            String name = xml.child(count).attributeValue("name");
            processFeed(url, file, outFile);
            // processes the individual feed
            outFile.print("<li>");
            outFile.print("<a href =" + file + ">" + name + " </a>");
            outFile.println("</li>");
            count++;
        }
        outFile.println("</ul>");

        outFile.println("</body> </html>");

        in.close();
        out.close();
        outFile.close();
        // closes all ins and outs
    }

}

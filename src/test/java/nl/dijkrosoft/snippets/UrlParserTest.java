/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Test;

/**
 *
 * @author DickD
 */
public class UrlParserTest {

    @Test
    public void testNormal() throws URISyntaxException {
        new URI("http://www.nu.nl");

    }

    @Test
    public void testParameterWithColon() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:Hyena");

    }

    @Test
    public void testParameterMultiplelHtmlEntities() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=d&amp;amp;dryRun=false");

    }

    @Test
    public void testOrignalWithoutColonAndHttpEncSpace() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportalHyena%20II&amp;amp;dryRun=false");

    }

    @Test
    public void testParameterHtmlEntity() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=amp;");

    }

    @Test
    public void testParameterWithSemicolon() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=;");

    }

    @Test
    public void testOriginalSpaceReplaceByUnderscore() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:Hyena_II&amp;amp;dryRun=false");

    }

    /**
     * Non parseable ULRs
     */
    @Test(expected = URISyntaxException.class)
    public void testOriginalCrashingUrl() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:Hyena II&amp;amp;dryRun=false");

    }

    @Test(expected = URISyntaxException.class)
    public void testParameterWithSpace() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportalHyena II");

    }

    @Test
    public void testOriginalWithoutSpace() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:HyenaII&amp;amp;dryRun=false");

    }

    @Test
    public void testOriginalWithEncodedSpace() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:Hyena%20II&amp;amp;dryRun=false");

    }

}

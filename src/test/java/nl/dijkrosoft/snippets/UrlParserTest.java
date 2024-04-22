/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author DickD
 */
class UrlParserTest {

    @Test
    void normal() throws URISyntaxException {
        new URI("http://www.nu.nl");

    }

    @Test
    void parameterWithColon() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:Hyena");

    }

    @Test
    void parameterMultiplelHtmlEntities() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=d&amp;amp;dryRun=false");

    }

    @Test
    void orignalWithoutColonAndHttpEncSpace() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportalHyena%20II&amp;amp;dryRun=false");

    }

    @Test
    void parameterHtmlEntity() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=amp;");

    }

    @Test
    void parameterWithSemicolon() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=;");

    }

    @Test
    void originalSpaceReplaceByUnderscore() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:Hyena_II&amp;amp;dryRun=false");

    }

    /**
     * Non parseable ULRs
     */
    @Test
    void originalCrashingUrl() throws URISyntaxException {
        assertThrows(URISyntaxException.class, () -> {
            new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:Hyena II&amp;amp;dryRun=false");

        });

    }

    @Test
    void parameterWithSpace() throws URISyntaxException {
        assertThrows(URISyntaxException.class, () -> {
            new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportalHyena II");

        });

    }

    @Test
    void originalWithoutSpace() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:HyenaII&amp;amp;dryRun=false");

    }

    @Test
    void originalWithEncodedSpace() throws URISyntaxException {
        new URI("http://RDSON1:9000/batch_bootstrap/properties?project=webportal:Hyena%20II&amp;amp;dryRun=false");

    }

}

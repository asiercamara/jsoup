package org.jsoup.nodes;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttributeValueWithJSTLTagTest {
    

    @Test public void booleanAttributesAreEmptyStringValues() {
        Document doc = Jsoup.parse("<img src=\"img/ico_buscar.png\" title=\"<bean:message bundle=\"_label\"  key=\"label.ayudaPuntoInteres\" />\" onclick=\"popUpWindow('ayudaPuntoInteresAction.do?method=buscarAyudaPuntoInteres&cdPuntoInteresPantalla='+document.forms[0].cdPuntoInteresPantalla.value+'&passbackCdPuntoInteres=cdPuntoInteresPantalla&passbackIdPuntoInteres=idPuntoInteres&passbackDsPuntoInteresAbrv=dsPuntoInteresAbrv',50,50,550,550)\" class=\"iconos\"/>");
        
        Element image = doc.select("img").get(0);
        assertNotNull(image);
        
        assertEquals("img/ico_buscar.png", image.attr("src"));
        assertEquals("<bean:message bundle=\"_label\"  key=\"label.ayudaPuntoInteres\" />", image.attr("title"));
        assertNotEquals("label.ayudaPuntoInteres", image.attr("key"));
        assertEquals("popUpWindow('ayudaPuntoInteresAction.do?method=buscarAyudaPuntoInteres&cdPuntoInteresPantalla='+document.forms[0].cdPuntoInteresPantalla.value+'&passbackCdPuntoInteres=cdPuntoInteresPantalla&passbackIdPuntoInteres=idPuntoInteres&passbackDsPuntoInteresAbrv=dsPuntoInteresAbrv',50,50,550,550)"
        		, image.attr("onclick"));
        
        assertTrue(image.hasClass("iconos"));
        
        // transformación a String
        String html = Parser.unescapeEntities(image.outerHtml(), false);
        String expected = "<img src=\"img/ico_buscar.png\" title=\"<bean:message bundle=\"_label\"  key=\"label.ayudaPuntoInteres\" />\" onclick=\"popUpWindow('ayudaPuntoInteresAction.do?method=buscarAyudaPuntoInteres&cdPuntoInteresPantalla='+document.forms[0].cdPuntoInteresPantalla.value+'&passbackCdPuntoInteres=cdPuntoInteresPantalla&passbackIdPuntoInteres=idPuntoInteres&passbackDsPuntoInteresAbrv=dsPuntoInteresAbrv',50,50,550,550)\" class=\"iconos\">";
        
        assertEquals(expected, html);
        
        
    }

    
}

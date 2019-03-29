package eu.lundegaard.email.template;

import com.itextpdf.text.DocumentException;
import eu.lundegaard.email.template.model.Person;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Jan Jaros on 3/29/2019
 **/

public class EmailGenerator {

    private static final String greetings = "Hello awesome world. Finally, I am alive!";

    public void generate() {
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");

        final Context context = new Context();
        context.setVariable("greetings", greetings);
        context.setVariable("person", createPerson());

        final TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        final String html = templateEngine.process("template.html", context);

        try {
            final OutputStream outputStream = new FileOutputStream("C:\\Lundegaard\\JXLSdemo\\autput\\PdfExample.pdf");
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
            outputStream.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }

    private Person createPerson() {
        return new Person("Karel", "Novak", 37, 40000);
    }
}
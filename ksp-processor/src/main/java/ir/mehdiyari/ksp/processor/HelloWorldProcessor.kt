package ir.mehdiyari.ksp.processor

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.google.devtools.ksp.validate
import ir.mehdiyari.annotations.HelloWorldAnnotation

/**
 * This is simple processor that use KSP API to generate
 * extension function for annotated classes with [HelloWorldAnnotation]
 */
class HelloWorldProcessor(
    private val helloWorldAnnotatedClassVisitor: KSVisitorVoid
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(HelloWorldAnnotation::class.qualifiedName!!)
        val returnList = symbols.filter { !it.validate() }.toList()
        symbols.filter { it is KSClassDeclaration && it.validate() }
            .forEach { it.accept(helloWorldAnnotatedClassVisitor, Unit) }
        return returnList
    }
}


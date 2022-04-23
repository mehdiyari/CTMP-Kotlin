package ir.mehdiyari.ksp.processor

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import ir.mehdiyari.ksp.visitors.HelloWorldAnnotatedClassVisitor

class HelloWorldProcessorProvider : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        HelloWorldProcessor(
            HelloWorldAnnotatedClassVisitor(
                logger = environment.logger,
                codeGenerator = environment.codeGenerator
            )
        )

}
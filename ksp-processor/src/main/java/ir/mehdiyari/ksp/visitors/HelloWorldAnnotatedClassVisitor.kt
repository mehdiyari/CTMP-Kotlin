package ir.mehdiyari.ksp.visitors

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

class HelloWorldAnnotatedClassVisitor(
    private val logger: KSPLogger,
    private val codeGenerator: CodeGenerator
) : KSVisitorVoid() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        super.visitClassDeclaration(classDeclaration, data)

        val packageName = classDeclaration.qualifiedName?.getQualifier() ?: kotlin.run {
            logger.error("packageName is empty")
            return
        }

        val className = classDeclaration.simpleName.getShortName()

        codeGenerator.createNewFile(
            dependencies = Dependencies(
                true,
                classDeclaration.containingFile!!
            ),
            packageName = packageName,
            fileName = "${className}_Generated"
        ).use { file ->
            file.write(
                """
                    package $packageName
                    
                    fun ${packageName}.${className}.printHelloWorldKSP() {
                        println("${className}: Hello world! This function generated by KSP")
                    }
                """.trimIndent().toByteArray()
            )
        }
    }

}
package ir.mehdiyari.ctmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rms = Person("Richard Matthew Stallman", 69)

        /**
         * Print Hello World message with
         * [printHelloWorldKSP] function that generated by KSP in :ksp-processor module
         */
        rms.printHelloWorldKSP()

        /**
         * Print Hello World message with
         * [printHelloWorldKapt] function that generated by Kapt in :kapt-processor module
         */
        rms.printHelloWorldKapt()
    }
}
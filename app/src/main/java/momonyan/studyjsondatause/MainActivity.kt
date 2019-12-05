package momonyan.studyjsondatause

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val assetManager = resources.assets

        val inputStream = assetManager.open("SampleJsonData.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val str: String = bufferedReader.readLine()
        Log.d("check", str)
        try {
            val jsonArray = JSONArray(str)
            for (i in 0 until jsonArray.length()) {
                val textView = TextView(this)
                Log.d("Check", jsonArray[i].toString())
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}

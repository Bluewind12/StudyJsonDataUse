package momonyan.studyjsondatause

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val assetManager = resources.assets

        val inputStream = assetManager.open("SampleJsonData.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val str: String = bufferedReader.readText()
        Log.d("check", str)
        try {
            val jsonObject = JSONObject(str)
            val jsonArray = jsonObject.getJSONArray("sample")
            val layout = mainLinerLayout
            for (i in 0 until jsonArray.length()) {
                val jsonData = jsonArray.getJSONObject(i)
                val nameTextView = TextView(this)
                val ageTextView = TextView(this)
                val genderTextView = TextView(this)
                val otherTextView = TextView(this)

                nameTextView.text = "Name : " + jsonData.getString("name")
                ageTextView.text = "Age : " + jsonData.getInt("age").toString()
                genderTextView.text = "Gender : " + if (!jsonData.getBoolean("gender")) {
                    "男"
                } else {
                    "女"
                }
                otherTextView.text = "Other : " + jsonData.getString("other")
                layout.addView(nameTextView)
                layout.addView(ageTextView)
                layout.addView(genderTextView)
                layout.addView(otherTextView)
                layout.addView(TextView(this))

            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}

package kr.hs.emirim.kkhhss.vote_10_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        title = "투표 결과"

        var intent = intent
        var voteCount = intent.getIntArrayExtra("voteCount")
        var imgName = intent.getStringArrayExtra("imgName")

        var tv = arrayOfNulls<TextView>(imgName!!.size)
        var rBar = arrayOfNulls<RatingBar>(imgName!!.size)

        var tvId = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3,
                           R.id.iv4, R.id.iv5, R.id.iv6,
                           R.id.iv7, R.id.iv8, R.id.iv9)

        var rBarId = arrayOf(
            R.id.rbar1, R.id.rbar2, R.id.rbar3,
            R.id.rbar4, R.id.rbar5, R.id.rbar6,
            R.id.rbar7, R.id.rbar8, R.id.rbar9
        )

        for (i in imgName.indices) {
            tv[i] = findViewById<TextView>(tvId[i])
            tv[i]!!.setText(imgName[i])
            rBar[i] = findViewById<RatingBar>(rBarId[i])
            rBar[i]!!.rating = voteCount!![i].toFloat()
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}
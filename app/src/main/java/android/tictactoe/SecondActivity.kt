package android.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*




class SecondActivity : AppCompatActivity() {

    private var blocks = arrayOfNulls<ImageView>(25)
    private var block = arrayOfNulls<String>( 25)

    private enum class TURN {
        CIRCLE, CROSS
    }

    private var mTurn: TURN? = null

    // var currentP = findViewById(R.id.) as TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        for (position in 0..24) {
            val resId = resources.getIdentifier("block_" + (position+1), "id", packageName)
            blocks[position] = findViewById<View>(resId) as ImageView
            blocks[position]?.setOnClickListener {
                makeMove(position)
            }
        }



        btnReset.setOnClickListener(View.OnClickListener {
            val starter = intent
            finish()
            starter.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            startActivity(starter)
        })

        btnBack.setOnClickListener{
            startActivity(Intent(this@SecondActivity, MainActivity::class.java))
        }




    }

    private fun makeMove(position: Int) {
        if (mTurn === TURN.CIRCLE) {
            blocks[position]?.setImageResource(R.drawable.circle)
            mTurn = TURN.CROSS
            currentP.text = "X TURN"
            block[position]="O"
        } else {
            blocks[position]?.setImageResource(R.drawable.cross)
            mTurn = TURN.CIRCLE
            currentP.text = "O TURN"
            block[position]="X"
        }
        blocks[position]?.isEnabled = false

        resultOut()
    }


    private fun resultOut(){
        if(hasWon("X") ){
            currentP.text = "X WIN"
            for (i in 0..24) blocks[i]?.isEnabled = false
        }else if(hasWon("O")){
            currentP.text = "O WIN"
            for (i in 0..24) blocks[i]?.isEnabled = false
        }
        if(isBoardFull()){
            currentP.text = "TIE"
        }
    }


    private fun hasWon(s: String): Boolean =
        if(block[0] == s && block[5] == s && block[10] == s && block[15] == s && block[20] == s) true
        else if(block[1] == s && block[6] == s && block[11] == s && block[16] == s && block[21] == s) true
        else if(block[2] == s && block[7] == s && block[12] == s && block[17] == s && block[22] == s) true
        else if(block[3] == s && block[8] == s && block[13] == s && block[18] == s && block[23] == s) true
        else if(block[4] == s && block[9] == s && block[14] == s && block[19] == s && block[24] == s) true
        else if(block[0] == s && block[1] == s && block[2] == s && block[3] == s && block[4] == s) true
        else if(block[5] == s && block[6] == s && block[7] == s && block[8] == s && block[9] == s) true
        else if(block[10] == s && block[11] == s && block[12] == s && block[13] == s && block[14] == s) true
        else if(block[15] == s && block[16] == s && block[17] == s && block[18] == s && block[19] == s) true
        else if(block[20] == s && block[21] == s && block[22] == s && block[23] == s && block[24] == s) true
        else if(block[0] == s && block[6] == s && block[12] == s && block[18] == s && block[24] == s) true
        else block[4] == s && block[8] == s && block[12] == s && block[16] == s && block[20] == s

    private fun isBoardFull(): Boolean {
        for (i in block)
            if(i != "X" && i != "O") return false
        return true
    }







    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@SecondActivity, MainActivity::class.java))
    }





}

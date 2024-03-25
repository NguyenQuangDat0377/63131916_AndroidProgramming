package ntu.a63131916;

import androidx.lifecycle.ViewModel

class BoardViewModel() : ViewModel() {
    val ROW = 36
    val COL = 20

    var board = Array(ROW) {
        Array(COL) { 0 }
    }

}
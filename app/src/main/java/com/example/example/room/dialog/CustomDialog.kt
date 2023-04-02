package com.example.example.room.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.example.R
import org.w3c.dom.Text

class CustomDialog(context: Context, Interface: CustomDialogInterface) : Dialog(context) {
    private var customDialogInterface: CustomDialogInterface = Interface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_dialog)

        var addButton = findViewById<Button>(R.id.btn_ok)
        var cancelButton = findViewById<Button>(R.id.btn_cancel)
        var etId = findViewById<EditText>(R.id.et_id)
        var etPw = findViewById<EditText>(R.id.et_pw)

        // 확인 버튼 클릭 시 onAddButtonClicked() 호출 후 종료
        addButton.setOnClickListener {
            val userId = etId.text.toString()
            val userPassword = etPw.text.toString()

            // 입력하지 않았을 때
            if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(userPassword)) {
                Toast.makeText(context, "데이터를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                customDialogInterface.onAddButtonClicked(userId, userPassword)
                dismiss()
            }

        }

        // 취소 버튼 클릭 시 onCancelButtonClicked() 호출 후 종료
        cancelButton.setOnClickListener {
            customDialogInterface.onCancelButtonClicked()
            dismiss()
        }
    }
}
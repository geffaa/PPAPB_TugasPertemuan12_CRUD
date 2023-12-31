package com.example.ppapb_tugaspertemuan12_crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ppapb_pertemuan12_note.R
import com.example.ppapb_pertemuan12_note.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)

        binding.backButton.setOnClickListener {
            // Panggil onBackPressed() atau finish() untuk menutup aktivitas
            onBackPressed()
        }

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val note = Note(0, title, content)
                db.insertNote(note)
                finish()
                Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
            } else {
                // Menampilkan pesan kesalahan jika EditText tidak diisi
                Toast.makeText(this, "Judul dan konten catatan harus diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

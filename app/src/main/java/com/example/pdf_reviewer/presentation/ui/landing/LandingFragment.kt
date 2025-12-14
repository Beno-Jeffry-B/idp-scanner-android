package com.example.pdf_reviewer.presentation.ui.landing

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pdf_reviewer.R

class LandingFragment : Fragment(R.layout.fragment_landing) {

    // PDF Selection Launcher
    private val pickPdfLauncher = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        if (uri != null) {
            // User successfully selected a file
            // (Optional) You can persist permission here if needed later:
            // requireContext().contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)

            // Navigate to Result Screen
            findNavController().navigate(R.id.action_landing_to_result)
        } else {
            Toast.makeText(requireContext(), "No file selected", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnStart = view.findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            // Launch System File Picker for PDFs only
            pickPdfLauncher.launch(arrayOf("application/pdf"))
        }
    }
}
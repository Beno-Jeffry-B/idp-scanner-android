package com.example.pdf_reviewer.presentation.ui.result

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.pdf_reviewer.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ResultFragment : Fragment(R.layout.fragment_result) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val tvProcessing = view.findViewById<TextView>(R.id.tvProcessing)
        val layoutContent = view.findViewById<LinearLayout>(R.id.layoutResultContent)

        // 3️⃣ Simulate Processing Delay
        // Using lifecycleScope to be safe (it cancels if the user leaves the screen)
        viewLifecycleOwner.lifecycleScope.launch {
            // Show Loading
            progressBar.visibility = View.VISIBLE
            tvProcessing.visibility = View.VISIBLE
            layoutContent.visibility = View.GONE

            // Wait for 2 seconds (simulating AI work)
            delay(2000)

            // Show Results
            progressBar.visibility = View.GONE
            tvProcessing.visibility = View.GONE
            layoutContent.visibility = View.VISIBLE
        }
    }
}
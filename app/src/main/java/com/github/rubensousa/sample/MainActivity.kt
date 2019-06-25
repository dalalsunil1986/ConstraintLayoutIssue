package com.github.rubensousa.sample

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var constrainedView: View
    private lateinit var hiddenView: View
    private val collapsedConstraintSet = ConstraintSet()
    private val expandedConstraintSet = ConstraintSet()
    private var expanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.constraintLayout)
        constrainedView = findViewById(R.id.frameLayout)
        hiddenView = findViewById(R.id.innerLayout)
        constrainedView.setOnClickListener {
            hiddenView.isVisible = !hiddenView.isVisible
        }
        hiddenView.setOnClickListener {
            if (expanded) {
                collapsedConstraintSet.applyTo(constraintLayout)
            } else {
                expandedConstraintSet.applyTo(constraintLayout)
            }
            hiddenView.isVisible = false
            expanded = !expanded
        }

        // Setup collapsed constraint set
        // View will be aligned to a guideline
        collapsedConstraintSet.constrainWidth(constrainedView.id, 0)
        collapsedConstraintSet.constrainHeight(constrainedView.id, 0)
        collapsedConstraintSet.setDimensionRatio(constrainedView.id, "16:9")
        collapsedConstraintSet.connect(
            constrainedView.id, ConstraintSet.TOP,
            constraintLayout.id, ConstraintSet.TOP
        )
        collapsedConstraintSet.connect(
            constrainedView.id, ConstraintSet.START,
            constraintLayout.id, ConstraintSet.START
        )
        collapsedConstraintSet.connect(
            constrainedView.id, ConstraintSet.END,
            R.id.guideline, ConstraintSet.START
        )

        // Setup expanded constraint set
        // View will fill the parent's width and height
        expandedConstraintSet.constrainWidth(constrainedView.id, 0)
        expandedConstraintSet.constrainHeight(constrainedView.id, 0)
        expandedConstraintSet.connect(
            constrainedView.id, ConstraintSet.TOP,
            constraintLayout.id, ConstraintSet.TOP
        )
        expandedConstraintSet.connect(
            constrainedView.id, ConstraintSet.START,
            constraintLayout.id, ConstraintSet.START
        )
        expandedConstraintSet.connect(
            constrainedView.id, ConstraintSet.END,
            constraintLayout.id, ConstraintSet.END
        )
        expandedConstraintSet.connect(
            constrainedView.id, ConstraintSet.BOTTOM,
            constraintLayout.id, ConstraintSet.BOTTOM
        )
    }
}

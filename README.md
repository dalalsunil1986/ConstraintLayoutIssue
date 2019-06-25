Steps to reproduce the bug in the sample app:
1. Click in the pink view.
2. Green view appears centered inside the pink view.
3. Click the green view.
4. Pink view is expanded to fullscreen and green view is hidden.
5. Click the pink view again.
6. Green view appears in the last center position from step 2 instead of being centered in the new dimension.

Expected:
Green view should appear again in the center of the screen.

Observations:
- If ConstraintLayout has width=WRAP_CONTENT and height=WRAP_CONTENT the behavior seems to correct.
- 2.0.0-beta1 turns the screen all white after step 1.
- 2.0.0-alpha5 and 2.0.0-alpha4 turns the screen all white after step 3.
- 2.0.0-alpha3 and 1.1.3 works correctly

Notice how a dependency change from 2.0.0-beta2 to 2.0.0-alpha3 or 1.1.3 makes the problem go away.

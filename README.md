# 🎮 Magnetic Cave Game

## 📝 Introduction
Magnetic Cave Game is a strategic board game implemented in Java. It allows two players to compete by placing pieces on a **9×9** board to form a **five-in-a-row** pattern. The game supports both **Player vs. Player (PvP)** and **Player vs. AI (PvAI)** modes, where the AI uses the **Minimax Algorithm with Alpha-Beta Pruning** to make decisions.

## ✨ Features
- **🎭 Game Modes:**
  - 🆚 Player vs. Player (PvP)
  - 🤖 Player vs. AI (PvAI) (Minimax-based AI opponent)
- **🔄 Turn-Based Gameplay:** Players take turns placing pieces.
- **✅ Move Validation:** Ensures only valid moves are allowed.
- **🏆 Winning Condition Checking:** Detects when a player achieves five in a row.
- **🧠 Artificial Intelligence:**
  - **Minimax Algorithm** determines the best move.
  - **Alpha-Beta Pruning** optimizes decision-making.
- **📊 Board Evaluation:** AI prioritizes moves based on an evaluation function.

## 🎮 How to Play
1. Run the game using the Java compiler:
   ```sh
   javac Ai.java
   java f.Ai
   ```
2. Choose a game mode:
   - **1️⃣ :** Player vs. Player
   - **2️⃣ :** Player vs. AI (Minimax)
   - **3️⃣ :** Exit
3. If you select **Player vs. AI**, choose whether to play as **⚫ Black (First Player)** or **⚪ White (Second Player).**
4. Enter your move by specifying the **row** and **column** (both between 1 and 8).
5. The game alternates turns until a player wins by forming a five-in-a-row sequence **horizontally, vertically, or diagonally**, or the game ends in a draw if the board is full.

## 🏁 Game Board Representation
- `_` : Empty Cell ➖
- `P` : Playable Position ✳️
- `B` : Black Piece ⚫ (Player 1)
- `W` : White Piece ⚪ (Player 2 / AI)

## 🤖 AI Implementation
The AI opponent utilizes the **Minimax Algorithm** with **Alpha-Beta Pruning** to efficiently search for the best move. It evaluates moves based on:
- Existing **piece sequences** on the board.
- Assigning weights to potential **winning combinations**.
- Choosing moves that maximize its advantage while blocking the opponent.

## 📜 Report Overview
The **project report** details:
1. **Game Initialization:** Menu selection for Player vs. Player or Player vs. AI.
2. **Win Conditions:** Horizontal, vertical, and diagonal five-in-a-row scenarios.
3. **AI Mechanics:** Explanation of the **Minimax Algorithm** and how it determines the best move.
4. **Evaluation Function:** Scoring system for board evaluation.
5. **Invalid Cases Handling:** Preventing incorrect moves and handling input errors.

For a detailed explanation, refer to the **full report (YazeedHamdan1201133Sec.3.pdf)**.

## 🚀 Future Enhancements
- 🔄 Improve AI depth selection dynamically for faster decisions.
- 🎯 Enhance board evaluation for more strategic play.
- 🖥️ Implement a graphical user interface (GUI).
- 🎚️ Add difficulty levels for AI opponents.

## 👨‍💻 Author
Developed by **Yazeed Hamdan** 🚀

## 🤝 Contributions
Feel free to fork the repository, report issues, or submit pull requests to improve the game! 🎉

## 📧 Contact
For any questions or suggestions, reach out via GitHub Issues or email. 📩

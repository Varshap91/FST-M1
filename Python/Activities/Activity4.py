while True:
    user1move = input("Enter User 1 move: ")
    user2move = input("Enter User 2 move: ")
    if user1move == 'Rock' and user2move == 'Scissors':
        print("User 1 Wins")
    elif user1move == 'Rock' and user2move == 'Paper':
        print("User 2 Wins")
    elif user1move == 'Rock' and user2move == 'Rock':
        print("The round is a draw")
    elif user1move == 'Paper' and user2move == 'Scissors':
        print("User 2 Wins")
    elif user1move == 'Paper' and user2move == 'Rock':
        print("User 1 Wins")
    elif user1move == 'Paper' and user2move == 'Paper':
        print("The round is a draw")
    elif user1move == 'Scissors' and user2move == 'Rock':
        print("User 2 Wins")
    elif user1move == 'Scissors' and user2move == 'Paper':
        print("User 1 Wins")
    elif user1move == 'Scissors' and user2move == 'Scissors':
        print("The round is a draw")
    else:
        print("Invalid input! You have not entered Rock, Paper or Scissors, try again.")

        # Ask for another round of play
    playAgain = input("Do you want to play another round? Yes/No: ")

    if playAgain == "Yes":
        pass
    # If they say no, exit the game
    elif (playAgain == "No"):
        raise SystemExit
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit

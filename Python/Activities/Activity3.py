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

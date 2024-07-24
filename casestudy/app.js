class SnakeGame {
    constructor() {
        this.squares = document.querySelectorAll('.grid div');
        this.scoreDisplay = document.querySelector('span');
        this.startBtn = document.querySelector('.start');
        this.pauseBtn = document.querySelector('.pause');
        this.width = 10;
        this.currentIndex = 0;
        this.appleIndex = 0;
        this.currentSnake = [2, 1, 0];
        this.direction = 1;
        this.score = 0;
        this.speed = 0.9;
        this.intervalTime = 1000; // Set initial interval time
        this.lastFrameTime = 0;
        this.lastUpdateTime = 0; // Add a separate timer for updates
        this.isPaused = false;
        this.applesEaten = 0;
        this.bigApple = false;

        this.startBtn.addEventListener('click', () => this.startGame());
        this.pauseBtn.addEventListener('click', () => this.togglePause());
        document.addEventListener('keyup', (e) => this.control(e));
    }

    startGame() {
        // Remove all snake and apple classes
        this.squares.forEach(square => {
            square.classList.remove('snake', 'apple', 'big-apple');
        });

        cancelAnimationFrame(this.animationFrameId); // Cancel any ongoing animation
        this.score = 0;
        this.applesEaten = 0;
        this.bigApple = false;
        this.randomApple();
        this.direction = 1;
        this.scoreDisplay.innerText = this.score;
        this.currentSnake = [2, 1, 0];
        this.currentIndex = 0;
        this.currentSnake.forEach(index => this.squares[index].classList.add('snake'));
        this.lastFrameTime = performance.now(); // Initialize the frame time
        this.lastUpdateTime = this.lastFrameTime; // Initialize the update time
        this.animationFrameId = requestAnimationFrame((timestamp) => this.play(timestamp)); // Start the game loop
    }

    play(timestamp) {
        if (this.isPaused) return;
        if (timestamp - this.lastUpdateTime >= this.intervalTime) {
            this.moveOutcomes();
            this.lastUpdateTime = timestamp;
        }
        this.animationFrameId = requestAnimationFrame((timestamp) => this.play(timestamp)); // Request next frame
    }

    moveOutcomes() {
        // Check if the snake hits the wall or itself
        if (
            (this.currentSnake[0] + this.width >= (this.width * this.width) && this.direction === this.width) || // Snake hits bottom
            (this.currentSnake[0] % this.width === this.width - 1 && this.direction === 1) || // Snake hits right wall
            (this.currentSnake[0] % this.width === 0 && this.direction === -1) || // Snake hits left wall
            (this.currentSnake[0] - this.width < 0 && this.direction === -this.width) || // Snake hits top
            this.squares[this.currentSnake[0] + this.direction].classList.contains('snake') // Snake goes into itself
        ) {
            cancelAnimationFrame(this.animationFrameId); // Cancel animation if any of the above happen
            return;
        }

        const tail = this.currentSnake.pop(); // Remove the last segment of the snake
        this.squares[tail].classList.remove('snake'); // Remove class of snake from the TAIL

        // Calculate new position of the snake head
        const newHead = this.currentSnake[0] + this.direction;

        // Deals with snake getting apple
        if (this.squares[newHead].classList.contains('apple') || this.squares[newHead].classList.contains('big-apple')) {
            // Determine if it's a big apple
            const isBigApple = this.squares[newHead].classList.contains('big-apple');

            // Remove the apple class from the square
            this.squares[newHead].classList.remove(isBigApple ? 'big-apple' : 'apple');

            // Add the snake class to the tail
            this.squares[tail].classList.add('snake');

            // Push the tail back to the snake array
            this.currentSnake.push(tail);

            // Increment apples eaten
            this.applesEaten++;

            // Handle big apple logic
            if (isBigApple) {
                this.bigApple = false; // Reset big apple flag
                this.intervalTime /= this.speed; // Return to normal speed
                this.score += 3; // Big apple gives 3 points
            } else {
                // Check if it's time for a big apple
                if (this.applesEaten % 5 === 0 && this.applesEaten > 0) {
                    this.bigApple = true; // Set big apple mode
                    this.intervalTime *= this.speed; // Speed up the game
                }
                this.score++; // Normal apple gives 1 point
            }

            // Update score display
            this.scoreDisplay.textContent = this.score;

            // Place a new apple on the grid
            this.randomApple();
        }

        // Move the snake head to the new position
        this.currentSnake.unshift(newHead);
        this.squares[this.currentSnake[0]].classList.add('snake'); // Add snake class to the new head position
    }

    randomApple() {
        do {
            this.appleIndex = Math.floor(Math.random() * this.squares.length);
        } while (this.squares[this.appleIndex].classList.contains('snake')); // Making sure apples don't appear on the snake

        // Check if it's a big apple and change its color
        if (this.bigApple) {
            this.squares[this.appleIndex].classList.add('big-apple');
        } else {
            this.squares[this.appleIndex].classList.add('apple');
        }
    }

    control(e) {
        if (e.keyCode === 39) {
            this.direction = 1; // If we press the right arrow on our keyboard, the snake will go right one
        } else if (e.keyCode === 38) {
            this.direction = -this.width; // If we press the up arrow, the snake will go back ten divs, appearing to go up
        } else if (e.keyCode === 37) {
            this.direction = -1; // If we press left, the snake will go left one div
        } else if (e.keyCode === 40) {
            this.direction = +this.width; // If we press down, the snake head will instantly appear in the div ten divs from where you are now
        }
    }

    togglePause() {
        this.isPaused = !this.isPaused;
        if (!this.isPaused) {
            this.lastUpdateTime = performance.now();
            this.animationFrameId = requestAnimationFrame((timestamp) => this.play(timestamp));
        }
    }
}

new SnakeGame(); // Create a new instance of the SnakeGame class

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
        this.intervalTime = 1000;
        this.lastFrameTime = 0;
        this.lastUpdateTime = 0;
        this.isPaused = false;
        this.applesEaten = 0;
        this.bigApple = false;

        this.startBtn.addEventListener('click', () => this.startGame());
        this.pauseBtn.addEventListener('click', () => this.togglePause());
        document.addEventListener('keyup', (e) => this.control(e));
    }

    startGame() {

        this.squares.forEach(square => {
            square.classList.remove('snake', 'apple', 'big-apple');
        });

        cancelAnimationFrame(this.animationFrameId);
        this.score = 0;
        this.applesEaten = 0;
        this.bigApple = false;
        this.randomApple();
        this.direction = 1;
        this.scoreDisplay.innerText = this.score;
        this.currentSnake = [2, 1, 0];
        this.currentIndex = 0;
        this.currentSnake.forEach(index => this.squares[index].classList.add('snake'));
        this.lastFrameTime = performance.now();
        this.lastUpdateTime = this.lastFrameTime;
        this.animationFrameId = requestAnimationFrame((timestamp) => this.play(timestamp));
    }

    play(timestamp) {
        if (this.isPaused) return;
        if (timestamp - this.lastUpdateTime >= this.intervalTime) {
            this.moveOutcomes();
            this.lastUpdateTime = timestamp;
        }
        this.animationFrameId = requestAnimationFrame((timestamp) => this.play(timestamp));
    }

    moveOutcomes() {

        if (
            (this.currentSnake[0] + this.width >= (this.width * this.width) && this.direction === this.width) ||
            (this.currentSnake[0] % this.width === this.width - 1 && this.direction === 1) ||
            (this.currentSnake[0] % this.width === 0 && this.direction === -1) ||
            (this.currentSnake[0] - this.width < 0 && this.direction === -this.width) ||
            this.squares[this.currentSnake[0] + this.direction].classList.contains('snake')
        ) {
            cancelAnimationFrame(this.animationFrameId);
            return;
        }

        const tail = this.currentSnake.pop();
        this.squares[tail].classList.remove('snake');


        const newHead = this.currentSnake[0] + this.direction;


        if (this.squares[newHead].classList.contains('apple') || this.squares[newHead].classList.contains('big-apple')) {

            const isBigApple = this.squares[newHead].classList.contains('big-apple');


            this.squares[newHead].classList.remove(isBigApple ? 'big-apple' : 'apple');


            this.squares[tail].classList.add('snake');


            this.currentSnake.push(tail);


            this.applesEaten++;


            if (isBigApple) {
                this.bigApple = false;
                this.intervalTime /= this.speed;
                this.score += 3;
            } else {

                if (this.applesEaten % 5 === 0 && this.applesEaten > 0) {
                    this.bigApple = true;
                    this.intervalTime *= this.speed;
                }
                this.score++;
            }


            this.scoreDisplay.textContent = this.score;


            this.randomApple();
        }


        this.currentSnake.unshift(newHead);
        this.squares[this.currentSnake[0]].classList.add('snake');
    }

    randomApple() {
        do {
            this.appleIndex = Math.floor(Math.random() * this.squares.length);
        } while (this.squares[this.appleIndex].classList.contains('snake'));


        if (this.bigApple) {
            this.squares[this.appleIndex].classList.add('big-apple');
        } else {
            this.squares[this.appleIndex].classList.add('apple');
        }
    }

    control(e) {
        if (e.keyCode === 39) {
            this.direction = 1;
        } else if (e.keyCode === 38) {
            this.direction = -this.width;
        } else if (e.keyCode === 37) {
            this.direction = -1;
        } else if (e.keyCode === 40) {
            this.direction = +this.width;
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

new SnakeGame();

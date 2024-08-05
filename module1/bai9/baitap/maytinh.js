let display = document.getElementById('display');
let currentOperation = '';
let firstOperand = '';
let secondOperand = '';

function appendNumber(number) {
    display.innerText += number;
}

function setOperation(operation) {
    firstOperand = display.innerText;
    currentOperation = operation;
    display.innerText = '';
}

function calculate() {
    secondOperand = display.innerText;
    let result;
    switch (currentOperation) {
        case '+':
            result = parseFloat(firstOperand) + parseFloat(secondOperand);
            break;
        case '-':
            result = parseFloat(firstOperand) - parseFloat(secondOperand);
            break;
        case '*':
            result = parseFloat(firstOperand) * parseFloat(secondOperand);
            break;
        case '/':
            result = parseFloat(firstOperand) / parseFloat(secondOperand);
            break;
        default:
            result = 'Error';
    }
    display.innerText = result;
}

function clearDisplay() {
    display.innerText = '';
    firstOperand = '';
    secondOperand = '';
    currentOperation = '';
}

function button1() {
    appendNumber(1);
}

function button2() {
    appendNumber(2);
}

function button3() {
    appendNumber(3);
}

function button4() {
    appendNumber(4);
}

function button5() {
    appendNumber(5);
}

function button6() {
    appendNumber(6);
}

function button7() {
    appendNumber(7);
}

function button8() {
    appendNumber(8);
}

function button9() {
    appendNumber(9);
}

function button0() {
    appendNumber(0);
}
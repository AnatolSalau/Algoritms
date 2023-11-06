const inputProcessing = require('./index');

const testData = [
      [['7', '0 0', '0 2', '2 2', '0 -2', '2 -2', '2 -1', '2 1', '2', '1 3'], 2], // №1
      [['4', '0 0', '1 0', '0 1', '1 1', '2', '1 4'], 1], // №2
      [['4', '0 0', '2 0', '0 2', '2 2', '1', '1 4'], -1], // №3

      [['3', '3 0', '0 0', '1 0', '2', '1 1'], 0], // test start = finish, если нельзя в ту же точку, то - 2
      [['3', '3 0', '0 0', '1 0', '3', '1 1'], 0], // test start = finish, если нельзя в ту же точку, то - 2
      [['3', '3 0', '0 0', '1 0', '1', '1 1'], 0], // test start = finish, если нельзя в ту же точку, то - -1
      //
];


let taskOne = inputProcessing(testData[0][0]);
/*let taskTwo = inputProcessing(testData[1][0]);
let taskThree = inputProcessing(testData[2][0]);*/

console.log("Task 1");
console.log("From 1 to 3, distance = 2");
console.log(taskOne);


/*console.log("Task 2");
console.log("From 1 to 4, distance = 2");
console.log(taskTwo);

console.log("Task 3");
console.log("From 1 to 4, distance = -1");
console.log(taskThree);*/

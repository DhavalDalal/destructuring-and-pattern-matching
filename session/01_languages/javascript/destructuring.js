// In FP, Destructuring is about extracting data from the innards of any structure.
// Destructuring list (or use as n-Tuple)
// Show this first
const list = [1,2,3,4,5,6]
let [first, second] = list
console.info("first = ", first);
console.info("second = ", second);
// Destructuring gives us a short-hand way of naming parts of the data-structure.
// then show by Adding to the above ...rest
[first, second, ...rest] = list
console.info("rest = ", rest);

// Destructuring Object
const name = {first: "Dhaval", last: "Dalal", salutation: 'Mr.'};
const {first: firstName, last: lastName} = name;
console.info(firstName);
console.info(lastName);

// Destructuring Function params
function capitalize({first: firstName, last: lastName}){
  return firstName.toUpperCase() + " " + lastName.toUpperCase();
}
console.info(capitalize(name));

// Destructuring Function params
function midpoint([x1,y1], [x2,y2] = [0,0]) { 
  function mid(a1, a2) { return (a1 + a2) / 2; }
  return [mid(x1, x2), mid(y1, y2)];
}

console.info(midpoint([2,3], [4,5]));
console.info(midpoint([2,3]));

// No need to show this - skip.
// Destructuring Map - No direct way
const map = new Map()
  .set('a', 2)
  .set('b', 4)
  .set('c', 8);
  
console.info(map);
// so you spread the map to check what is represented as internally
console.info(...map);
// it's list, so we destructure the list.
const [[fKey, fVal], [sKey,sVal], [tKey,tVal]] = map
console.info(fKey, fVal, sKey, sVal, tKey, tVal);

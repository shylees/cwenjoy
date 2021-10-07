export function toEdit(edit, params) {
  for (let i = 0; i < params.length; i++) {
    const element = document.querySelector("." + params[i]);
    // console.log(element);
    const value = element.textContent.trim();
    // console.log(value);
    element.innerText = "";
    const input = document.createElement("input");
    input.value = value;
    input.className = "editinput"
    element.appendChild(input)
    // console.log(element);

  }
}

export function getChangeValues(params) {
  let user = {};
  for (let i = 0; i < params.length; i++) {
    const element = document.querySelector("." + params[i]).querySelector('input');
    const value = element.value.trim();
    user[params[i]] = value;
    // console.log(user);
    document.querySelector("." + params[i]).removeChild(document.querySelector('.' + params[i]).querySelector('input'))
    document.querySelector("." + params[i]).innerText = value;
  }
  return user;

}

// export function getChangeValues(params) {
//   let values = [];
//   let user = {};
//   for (let i = 0; i < params.length; i++) {
//     const element = document.querySelector("." + params[i]).querySelector('input');
//     // console.log(element);
//     const value = element.value.trim();
//     // console.log(value);
//     user[params[i]] = value;
//     values.push(value);
//     element.removeChild(document.querySelector('.' + params[i]).querySelector('input'))
//   }

//   console.log(user);
//   return user;
// }

export function toSubmit(classnames, values) {
  console.log(values);
  for (let i = 0; i < classnames.length; i++) {
    const element = document.querySelector('.' + classnames[i]);
    element.removeChild(document.querySelector('.' + classnames[i]).querySelector('input'))
    // console.log(element);
    element.innerText = values[i];
    // console.log(element);
  }

}

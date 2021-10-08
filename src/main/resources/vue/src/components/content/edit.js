export function toEdit(edit, params) {
  for (let i = 0; i < params.length; i++) {
    const element = document.querySelector("." + params[i]);
    // console.log(element);
    const value = element.textContent.trim();
    // console.log(value);
    element.innerText = "";
    const input = document.createElement("input");
    input.value = value;
    input.type = "text"
    input.style.cssText = "outline:none;width: 80%;height: 2.4em;font-size: 0.8em;padding: 0 10px;line - height: 2.4em;color: #777;border: #111 1px solid;border-radius: 8px; "
    element.appendChild(input)

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

const signinBtn = document.getElementById("signin");
const signupBtn = document.getElementById("signup");
const fistForm = document.getElementById("from1");
const secondForm = document.getElementById("from2");
const container = document.querySelector(".container");

signinBtn.addEventListener("click",(a)=>{
    container.classList.remove("right-panel-active")
})

signupBtn.addEventListener("click",(b)=>{
    container.classList.add("right-panel-active")
})

fistForm.addEventListener("submit",(a)=> e.preventDefault())
secondForm.addEventListener("submit",(b)=> e.preventDefault())


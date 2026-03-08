let rating = 0;

const stars = document.querySelectorAll(".star");

stars.forEach(star=>{
    star.addEventListener("click", function(){

        rating = this.dataset.value;

        stars.forEach(s=>s.classList.remove("move"));

        for(let i=0;i<rating;i++){
            stars[i].classList.add("move");
        }

    });
});

function submit(){

}
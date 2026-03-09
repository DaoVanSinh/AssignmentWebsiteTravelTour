let rating = 0;

const stars = document.querySelectorAll(".star");
const reviewList = document.getElementById("list");

for (let i = 0; i < stars.length; i++) {

    stars[i].addEventListener("click", function () {

        rating = parseInt(this.getAttribute("data-value"));

        for (let j = 0; j < stars.length; j++) {
            stars[j].classList.remove("move");
        }

        for (let j = 0; j < rating; j++) {
            stars[j].classList.add("move");
        }

    });

}

function submit() {

    let email = document.getElementById("email").value.trim();
    let comment = document.getElementById("comment").value.trim();

    if (email === "" || comment === "") {
        alert("Vui lòng nhập đầy đủ thông tin");
        return;
    }

    if (rating === 0) {
        alert("Vui lòng chọn số sao");
        return;
    }

    let data = {
        tourId: 1,
        email: email,
        rating: rating,
        comment: comment
    };

    fetch("http://localhost:8080/api/reviews", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(res => res.json())
        .then(function () {

            document.getElementById("comment").value = "";
            rating = 0;

            for (let i = 0; i < stars.length; i++) {
                stars[i].classList.remove("move");
            }

            loadReviews();

        })
        .catch(function () {
            alert("Có lỗi xảy ra");
        });

}

function loadReviews() {

    fetch("http://localhost:8080/api/reviews/tour/1")
        .then(res => res.json())
        .then(function (reviews) {

            reviewList.innerHTML = "";

            if (reviews.length === 0) {
                reviewList.innerHTML = "<p>Chưa có đánh giá</p>";
                return;
            }

            reviews.forEach(function (r) {

                let starsText = "";

                for (let i = 0; i < r.rating; i++) {
                    starsText += "★";
                }

                let html =
                    '<div class="cmt_item">' +
                    '<h3>' + r.email + '</h3>' +
                    '<h4>' + starsText + '</h4>' +
                    '<h4>' + r.comment + '</h4>' +
                    '</div>';
                
                reviewList.innerHTML += html;
            });
        });
}

document.addEventListener("DOMContentLoaded", function () {
    loadReviews();
});
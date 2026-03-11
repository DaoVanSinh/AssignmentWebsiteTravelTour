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

            let count1 = 0;
            let count2 = 0;
            let count3 = 0;
            let count4 = 0;
            let count5 = 0;

            let totalScore = 0;

            reviews.forEach(function (r) {

                totalScore += r.rating;

                if (r.rating === 1) count1++;
                if (r.rating === 2) count2++;
                if (r.rating === 3) count3++;
                if (r.rating === 4) count4++;
                if (r.rating === 5) count5++;

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

            let total = reviews.length;
            let avg = (totalScore / total).toFixed(1);

            document.getElementById("TBscore").innerText = avg;
            document.getElementById("total").innerText = total + " đánh giá";

            document.getElementById("count1").innerText = count1;
            document.getElementById("count2").innerText = count2;
            document.getElementById("count3").innerText = count3;
            document.getElementById("count4").innerText = count4;
            document.getElementById("count5").innerText = count5;

            document.getElementById("bar1").style.width = (count1 / total * 100) + "%";
            document.getElementById("bar2").style.width = (count2 / total * 100) + "%";
            document.getElementById("bar3").style.width = (count3 / total * 100) + "%";
            document.getElementById("bar4").style.width = (count4 / total * 100) + "%";
            document.getElementById("bar5").style.width = (count5 / total * 100) + "%";
        });
}

document.addEventListener("DOMContentLoaded", function () {
    loadReviews();
});
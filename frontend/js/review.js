let rating = 0;

function initReview() {

    const stars = document.querySelectorAll(".star");

    stars.forEach(star => {
        star.addEventListener("click", function () {

            rating = this.dataset.value;

            stars.forEach(s => s.classList.remove("active"));

            for (let i = 0; i < rating; i++) {
                stars[i].classList.add("active");
            }
        });
    });

    loadReviews();
}

async function loadReviews() {

    const params = new URLSearchParams(window.location.search);
    const tourId = params.get("id");

    try {
        const res = await fetch(`http://localhost:8080/api/reviews/tour/${tourId}`);
        const reviews = await res.json();

        const container = document.getElementById("review-list");
        container.innerHTML = "";

        reviews.forEach(r => {

            let starsHtml = "★".repeat(r.rating) + "☆".repeat(5 - r.rating);

            container.innerHTML += `
                <div class="review-item">
                    <div class="email">${r.email}</div>
                    <div class="stars">${starsHtml}</div>
                    <div>${r.comment}</div>
                </div>
            `;
        });

    } catch (err) {
        console.error("Lỗi load review:", err);
    }
}

async function submitReview() {

    const email = document.getElementById("email").value;
    const comment = document.getElementById("comment").value;

    const params = new URLSearchParams(window.location.search);
    const tourId = params.get("id");

    const data = {
        tourId: tourId,
        userId: 1,
        email: email,
        rating: rating,
        comment: comment
    };

    try {

        const res = await fetch("http://localhost:8080/api/reviews", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (res.ok) {
            alert("Đánh giá thành công!");
            document.getElementById("review-form").style.display = "none";
            loadReviews();
        } else {
            alert("Gửi thất bại");
        }

    } catch (err) {
        console.error(err);
        alert("Lỗi server");
    }
}
function toggleReviewForm() {

    const form = document.getElementById("review-form");

    if (form.style.display === "none") {
        form.style.display = "block";
    } else {
        form.style.display = "none";
    }
}

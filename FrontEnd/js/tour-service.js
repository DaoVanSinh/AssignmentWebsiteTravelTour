const API = "http://localhost:8080/api/tours";

async function getTours() {

    const res = await fetch(API);
    return res.json();

}

async function addTour(tour) {

    await fetch(API + "/manage", {

        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(tour)

    });

}

async function updateTour(id, tour) {

    await fetch(API + "/manage/" + id, {

        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(tour)

    });

}

async function deleteTour(id) {

    await fetch(API + "/manage/" + id, {

        method: "DELETE"

    });

}
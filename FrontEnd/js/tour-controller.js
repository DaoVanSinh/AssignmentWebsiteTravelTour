let editId = null;

document.addEventListener("DOMContentLoaded", loadTours);

async function loadTours() {

    const tours = await getTours();

    const table = document.getElementById("tour-data");

    table.innerHTML = "";

    tours.forEach(t => {

        table.innerHTML += `
        <tr>
        <td>${t.id}</td>
        <td>${t.name}</td>
        <td>${t.price}</td>
        <td>${t.startDate}</td>
        <td>${t.endDate}</td>

        <td>
        <button onclick="editTour(${t.id},'${t.name}',${t.price},'${t.startDate}','${t.endDate}','${t.imageUrl}')">Sửa</button>
        <button onclick="removeTour(${t.id})">Xóa</button>
        </td>

        </tr>
        `;
    });

}

function openAddModal() {

    editId = null;

    document.getElementById("modalTitle").innerText = "Thêm Tour";

    document.getElementById("tourModal").style.display = "block";

}

function editTour(id,name,price,start,end,image) {

    editId = id;

    document.getElementById("modalTitle").innerText = "Sửa Tour";

    document.getElementById("name").value = name;
    document.getElementById("price").value = price;
    document.getElementById("startDate").value = start;
    document.getElementById("endDate").value = end;
    document.getElementById("imageUrl").value = image;

    document.getElementById("tourModal").style.display = "block";

}

async function saveTour() {

    const tour = {

        name: document.getElementById("name").value,
        price: document.getElementById("price").value,
        startDate: document.getElementById("startDate").value,
        endDate: document.getElementById("endDate").value,
        imageUrl: document.getElementById("imageUrl").value

    };

    if(editId){

        await updateTour(editId,tour);

    }else{

        await addTour(tour);

    }

    closeModal();

    loadTours();

}

async function removeTour(id){

    if(confirm("Xóa tour?")){

        await deleteTour(id);

        loadTours();

    }

}

function closeModal(){

    document.getElementById("tourModal").style.display = "none";

}

function previewImage() {
    const url = document.getElementById("imageUrl").value;
    const img = document.getElementById("imagePreview");

    if (url) {
        img.src = url;
        img.style.display = "block";
    } else {
        img.style.display = "none";
    }
}
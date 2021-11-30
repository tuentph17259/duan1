var products = [
  {
    id: "1",
    name: "ĐT 1280",
    img: "https://cdn.tgdd.vn/Products/Images/42/22701/dien-thoai-di-dong-Nokia-1280-dienmay.com-l.jpg",
    price: 1000,
    status: false
  },
  {
    id: "2",
    name: "Điện thoại đời cụ nội",
    img: "https://didongco.com.vn/wp-content/uploads/2019/05/3310-c%E1%BB%95-8.jpg",
    price: 400,
    status: true
  },
  {
    id: "3",
    name: "Iphone Trung Quốc",
    img: "https://www.techone.vn/wp-content/uploads/2019/10/Untitled-1.jpg",
    price: 400,
    status: false
  },
  {
    id: "4",
    name: "S20 Ultra",
    img: "https://didongviet.vn/pub/media/catalog/product/g/a/galaxy-s20-ultra-xam-didongviet_1.jpg",
    price: 400,
    status: true
  },
  {
    id: "5",
    name: "6300 Mạ Vàng",
    img: "https://vertuvietnam.com/wp-content/uploads/2019/12/sp-nokia-6700-classic-2-3.jpg",
    price: 400,
    status: false
  },
  {
    id: "6",
    name: "Ve sờ Tu mạ Vàng",
    img: "https://vertuvietnam.com/wp-content/uploads/2019/12/Vertu-Signature-S-xanh-navy-da-ca-sau-3.jpg",
    price: 400,
    status: true
  }

];

function showProduct() {
  var productDiv = document.getElementById("product");
  for (var i = 0; i < products.length; i++) {
    productDiv.innerHTML += `
            <div class="item">
                <h2 class="product-name">${products[i].name}</h2>
                <img src="${products[i].img}" alt="" class="product-img">
                <p class="product-price">${products[i].price}</p>
                <p class="product-status">${products[i].status ? " Tình Trạng :Còn hàng" : "Tình Trạng:Hết hàng"
      }</p>
                <button class="btn-add" onclick="addToCart(${products[i].id
      })">Add to cart</button>
            </div>
        `;
  }
}
showProduct();


var cartData = [];
function addToCart(id) {
  for (var i = 0; i < products.length; i++) {
    if (products[i].id == id) {
      var newProduct = {
        id: products[i].id,
        name: products[i].name,
        img: products[i].img,
        price: products[i].price,
        status: products[i].status
      };
    }
  }
  console.log(newProduct);
  if (newProduct.status == false) {
    alert("Het hang roi, chon cai khac di");
  } else {
    cartData.push(newProduct);
    alert("Ban da them vao gio hang thanh cong");
  }
  console.log(cartData);
  showCart();
}

function showCart() {
  var tableData = document.getElementById("table-data");
  tableData.innerHTML = "";
  var total = 0;
  for (var i = 0; i < cartData.length; i++) {
    //cchuoi
    tableData.innerHTML += `
            <tr>
                <td>${i + 1}</td>
                <td>${cartData[i].name}</td>
                <td> <img src="${cartData[i].img}" alt=""> </td>
                <td>${cartData[i].price}</td>
                <td>${cartData[i].status ? "Con hang" : "Het hang"}</td>
            </tr>
        `;
    
    total = total + cartData[i].price;
  }
  var tableTotal = document.getElementById("total");
  tableTotal.innerHTML = total;
}

var btnRemove = document.getElementById("btn-remove");

btnRemove.onclick = function () {
  
  cartData.splice(0, cartData.length);
  
    
  showCart();
  alert("xóa hết mất rôi");
  
};

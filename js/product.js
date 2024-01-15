const requestUrl = "http://localhost:8080/BiddingSystem/ProductsServer";

const xhr = new XMLHttpRequest();
xhr.open('GET', requestUrl);
xhr.onreadystatechange = function () {

    const mainDiv = document.querySelector('.products-container');

    if (xhr.readyState === 4) {
        const productData = JSON.parse(this.responseText); // 'this' references to xhr (current context)
        console.log(productData)
    productData.forEach(data => {
        let containerDiv = document.createElement('div');
        containerDiv.className = 'product-items';

        const innerHtml = `
        <div class="product-image">
            <img src="./images/${data.productImg}" alt="${data.productImg}" width="150" height="150" location="lazy">
        </div>

        <div class="product-Description">
                <div class="productName">
                    <h4> ${data.productName}</h4>
                </div>

                <div class="product-desc">
                    ${data.productDescription}
                </div>

                <div class="product-price">
                    RS.  ${data.productAmount}
                </div>
                
                <div class="product-bid">
                    <a href="BidPage.html">Bid Now</a>
                </div>
            </div>
        </div>
        `;

        containerDiv.innerHTML = innerHtml;
        mainDiv.appendChild(containerDiv);
    });
    }
};
xhr.send();

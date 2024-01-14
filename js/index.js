const backimages= document.querySelectorAll('.main-landing .image-slider img');

backimages.forEach( (imgs) => {

imgs.addEventListener("click",function(){

    let image = imgs.getAttribute("src");

    document.querySelector(".main-landing .imagebackground").style.background = `url(${image})`;
    document.querySelector(".main-landing .imagebackground").style.backgroundSize = 'cover';
})
})


const selectElement = document.getElementById('categoryselection');

selectElement.addEventListener('change' , function() {
    let selectedValue = selectElement.value;

    console.log(selectedValue)

    switch(selectedValue){
        case 'Shoes':
            window.location.href = 'Shoes.html';
            break;

        case 'clothes':
            window.location.href = 'Clothes.html';
            break;

        case 'Bags':
            window.location.href = 'Bags.html';
            break;

        case 'Antique':
            window.location.href = 'Antique.html';
            break;

        case 'Arts':
            window.location.href = 'Arts.html';
            break;

            default:
                break;
    }
})
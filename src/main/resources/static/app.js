// document.getElementsByTagName("input");
// console.log(document.getElementsByTagName("input"));
// /*
// for (let i = 1; i <= 3; i++) {
//     document.getElementById(`check${i}`).addEventListener("click", (e) => {
//       console.log(e.target.value);
//       //const value= document.getElements
//       //   requestData("post", "sasara" , i)
//     });
//   }*/

//   for(let i=0; i<document.getElementsByClassName(`check`).length; i++){
//     console.log(i)
//     document.getElementsByClassName(`check`)[i].addEventListener("click", (e) => {
//           console.log(e.target.value);

//             const value=e.target.value

//           requestData("post", "/update" , value)
//         });
//     }

//     const requestData = (method = "post", URL, data) => {
//     const xhr = new XMLHttpRequest();

//     xhr.open(method, URL, true); 
//     xhr.setRequestHeader("Content-type", "text/plain")
    
//     xhr.addEventListener("load", () => {
//         if (xhr.status == 200) {
//             console.log("succes");
//         }
//     });
//     xhr.send(data);
//     };


class HandlerAJAXPost {

  constructor({
      URL,
      data,
  }) {
      this._method = "post"; //Metodo de peticion AJAX @Type:String
      this._URL = URL || ""; //URL de envio de datos @Type:String
      this._data = data || "none"; //Data Enviada @Type:String 
  }

  //Metodo de Peticion AJAX @method => Do AJAX POST to @URL
  requestData() {

      const xhr = new XMLHttpRequest();
      xhr.open(this._method, this._URL, true);
      xhr.setRequestHeader("Content-type", "text/plain");

      //EventHandler listener AJAXstate 4
      xhr.addEventListener("load", () => {
          if (xhr.status == 200) {
              console.log("Request Success"); //LOG Success
          } else {
              console.error("Request Fail"); //LOG Fail
          };
      });

      xhr.send(this._data); //Data Enviada @Type:String 
  };

};

for (let i = 0; i < document.getElementsByClassName('check').length; i++) {

  //EventHandler listener @Input -> Type:checkbox
  document.getElementsByClassName('check')[i].addEventListener("click", (e) => {

      const value = e.target.value; //Data Save @Type:String 

      //Build HandlerAJAXPost
      const AJAX = new HandlerAJAXPost({
          URL: "/update", //URL de envio de datos @Type:String
          data: value, //Data Enviada @Type:String 
      });

      AJAX.requestData(); //Do AJAX POST
  });
};
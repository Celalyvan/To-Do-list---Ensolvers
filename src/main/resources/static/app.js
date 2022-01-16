
class HandlerAJAXPost {

  constructor({
      URL,
      data,
  }) {
      this._method = "post";
      this._URL = URL || "";
      this._data = data || "none";
  }


  requestData() {

      const xhr = new XMLHttpRequest();
      xhr.open(this._method, this._URL, true);
      xhr.setRequestHeader("Content-type", "text/plain");



      //EventHandler listener AJAXstate 4
      xhr.addEventListener("load", () => {
          if (xhr.status == 200) {
              console.log("Request Success");
          } else {
              console.error("Request Fail");
          };
      });

      xhr.send(JSON.stringify(this._data)); //Data sent @Type:String
  };

};

for (let i = 0; i < document.getElementsByClassName('check').length; i++) {

  //EventHandler listener @Input -> Type:checkbox
  document.getElementsByClassName('check')[i].addEventListener("click", (e) => {

      const value = e.target.value; //Data Save @Type:String 


      const AJAX = new HandlerAJAXPost({
          URL: "/update",
          data: value,
      });

      AJAX.requestData();
  });
};
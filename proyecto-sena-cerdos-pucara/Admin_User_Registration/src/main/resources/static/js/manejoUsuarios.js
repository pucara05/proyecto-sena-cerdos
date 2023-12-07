function selecionarModificar(){

var table = document.getElementById("tablon");

for(var i = 1; i < table.rows.length;i++)
{
table.rows[i].onclick =function()
{
    document.getElementById("idUpdate").value = this.cells[0].innerHTML;
    document.getElementById("nameUpdate").value = this.cells[1].innerHTML;
    document.getElementById("passwordUpdate").value = this.cells[2].innerHTML;

};

}

}



function selecionarEliminar(){

var table = document.getElementById("tablon");

for(var i = 1; i < table.rows.length;i++)
{
table.rows[i].onclick =function()
{
    document.getElementById("idDelete").value = this.cells[0].innerHTML;
    document.getElementById("nameDelete").value = this.cells[1].innerHTML;
    document.getElementById("passwordDelete").value = this.cells[2].innerHTML;

};

}

}
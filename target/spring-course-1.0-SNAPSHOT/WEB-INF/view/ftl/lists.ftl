<div id="header">
    <h2>Filter Users</h2>
</div>
<div id="content">
    <fieldset>
        <legend>Add Car</legend>
        <form name="car" action="add" method="post">
            User Id : <input type="text" name="id" /><br/>
            User Email : <input type="text" name="email" /><br/>
            User Tickets: <input type="text" name="tickes" /><br/>
            <input type="submit" value="Save" />
        </form>
    </fieldset>
    <br/>
    <table class="datatable">
        <tr>
            <th>User Id</th>
            <th>User Name</th>
            <th>User Email</th>
        </tr>
    <#list model ["userList"] as user>
        <tr>
            <td>${user}</td>
            <td>${user}</td>
            <td>${user}</td>
        </tr>
    </#list>

    </table>
</div>
<#import "parts/temp.ftl" as i>
<@i.page>

<body>
<div class="row">
    <div class="col-6">
        <form action="category/add" method="post">
            <div class="form-group">
                    <div class="col-sm-6">
                        <div> Название новой категории : </div>
                        <input type="text"name="name" class="form-control mt-3" placeholder="Введите название категории"/>
                        <button type="submit" class="btn btn-primary mt-3"/>Добавить категорию</button>
                    </div>
            </div>
        </form>
    </div>
</div>
<div class="row mt-6">
    <div class="col-6 ">
        <div>
            <h3>Список категорий</h3>
        </div>
        <table>
            <thead>
                <tr>
                    <th>
                        Название категории
                    </th>
                </tr>
            </thead>
            <tbody>
                <#list category as item>
                    <tr>
                        <td>
                            ${item.name}
                        </td>
                        <td>
                            <a href="category/del/${item.id}">Удалить</a>
                        </td>
                    </tr>
                <#else>
                    Категорий нет
                </#list>
            </tbody>
        </table>
    </div>
</div>
</body>
</@i.page>
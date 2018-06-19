<#import "parts/temp.ftl" as i>

<@i.page>
<div class="row">
    <div  id="collapseExample" class="col-6">
        <div class="form-group mt-3">
            <form method="post" action="/add" enctype="multipart/form-data" >
                <div class="form-group">
                    <input class="form-control" type="text" name="title" placeholder="введите название"">
                </div>
                <div class="form-group">
                    <textarea class="form-control" id="exampleTextarea" rows="3" name="text" placeholder="введите текст">
                    </textarea>
                </div>
                <div class="form-group">
                    <select class="form-control" name="category"  placeholder="введите Категорию" >
                        <#list category as cat>
                            <option value="${cat.id}">${cat.name}</option>
                        <#else>
                            <option>Нет категорий</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Отправить</button>
                </div>
            </form>
        </div>
    </div>
    <div class="col-2"></div>
    <div class="form-group col-4">
        <form method="post" action="/">
            <div class="row">
                <div class="col">
                    <div class="row mb-3">
                    Выберете категорию поиска
                    </div>
                    <div class="row">
                        <select multiple class="form-control" id="exampleFormControlSelect" name="selectCategory">
                            <#list category as select>
                                <option value="${select.id}">${select.name}</option>
                            <#else>
                                <option>Нет категорий</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group md-6 mt-3">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="inTitle">
                            <label class="form-check-label" for="inlineCheckbox1">Искать в названии</label>
                        </div>
                         <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox2" name="inText">
                            <label class="form-check-label" for="inlineCheckbox2">Искать в содержании</label>
                        </div>
                     </div>
                    <div class="form-inline">
                        <input type="text" name="filter" value="" class="form-control" placeholder="Поиск">
                        <button type="submit" class="btn btn-primary ml-2">Поиск</button>
                    </div>
                </div>
            </div>
        </form>
</div>

<div class="row">
    <div class="card-columns">
        <#list news as item>
            <div class="card my-3">
                <div class="card-header">
                    <h5>${item.title}</h5>
                </div>
                <div class="m-2">
                    <span>${item.text}</span>
                </div>
                <div class="card-footer text-muted">
                    <b>${item.parent.name}</b> Дата: ${item.date}
                    <div>
                        <a href="/del/${item.id}">Удалить</a>
                    </div>
                </div>
            </div>
        <#else>
        No news
        </#list>
    </div>
</div>
</@i.page>
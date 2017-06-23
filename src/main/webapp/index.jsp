<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Simulação de Alíquota Efetiva de Imposto de Renda</h2>  
<!--<h3>Preencha o formulário para realizar os Cálculos:</h3>-->
<h4 style="color: red;font-weight: bolder">${requestScope.msg}</h4>
<div class="footer"> 
    <div class="group"> 
        <div class="col span_2_of_5">
            <div style="">
                <h4>Ano Base: 2017</h4>
                <form action="irrf" method="POST">
                    <input type="hidden" name="op" value="calculo"/>
                    <fieldset>
                        <fieldset class="grupo"  style="border: solid 1px gray; padding: 3px;">
                            <div class="campo">
                                <label for="cpNome">1. Nome</label>
                                <input type="text" id="cpNome" name="cpNome" style="width: 10em" value="" />
                            </div>

                        </fieldset>
                        <fieldset class="grupo" style="border: solid 1px gray; padding: 3px;">
                            <div class="campo">
                                <label for="cpRend">2. Rendimentos tributáveis (Anual)</label>
                                <input type="text" class="bc imp" id="cpRend" name="cpRend" style="width: 10em" value="0,00" />
                            </div>

                        </fieldset>
                        <fieldset class="grupo" style="border: solid 1px gray; padding: 3px;">
                            <div class="campo">
                                <label for="cpContri">3. Deduções</label>
                            </div>
                            <div class="campo">
                                <label for="cpContri" style="margin-left: 8px;"> 3.1 Previdência Oficial  (Anual)</label>
                                <input type="text" class="ded bc imp" id="cpContri" name="cpContri" style="width: 10em" value="0,00" />
                            </div>
                            <div class="campo">
                                <label for="cpDepend" style="margin-left: 8px;"> 3.2 Dependente (quantidade)</label>
                                <input type="number" class="ded bc imp" id="cpDepend" name="cpDepend" style="width: 10em" value="0" />
                            </div>
                            <div class="campo">
                                <label for="cpPensao" style="margin-left: 8px;"> 3.3 Pensão alimentícia  (Anual)</label>
                                <input type="text" class="ded bc imp" id="cpPensao" name="cpPensao" style="width: 10em" value="0,00" />
                            </div>
                            <div class="campo">
                                <label for="cpMedico" style="margin-left: 8px;"> 3.4 Despesas Médicas  (Anual)</label>
                                <input type="text" class="ded bc imp" id="cpMedico" name="cpMedico" style="width: 10em" value="0,00" />
                            </div>
                            <div class="campo">
                                <label for="cpEducacao" style="margin-left: 8px;"> 3.5 Despesas Educação  (Anual)</label>
                                <input type="text" class="ded bc imp" id="cpEducacao" name="cpEducacao" style="width: 10em" value="0,00" />
                            </div>
                            <div class="campo">
                            </div>
                            <div class="campo">
                            </div>
                            <div class="campo">
                                <label for="cpOutras" style="margin-left: 8px;"> 3.6 Outras Deduções  (Anual)</label>
                                <input type="text" class="ded bc imp" id="cpOutras" name="cpOutras" style="width: 10em" value="0,00" />
                            </div>
                            <div class="campo">
                                <hr />
                            </div>
                            <div class="campo">
                                <label for="cpDeducoes" style="margin-left: 8px;"> 3.7 Total de Deduções</label>
                                <input type="text" id="cpDeducoes" name="cpDeducoes"  readonly="true"
                                       style="width: 10em;border: none;box-shadow: none;" 
                                       value="R$ 0,00" />                                
                            </div>
                        </fieldset>
                        <fieldset class="grupo" style="border: solid 1px gray; padding: 3px;">
                            <div class="campo">
                                <label for="cpBase">4. Base de cálculo (2 - 3.7)</label>
                                <input type="text" class="bc" id="cpBase" name="cpBase"  readonly="true"
                                       style="width: 10em;border: none;box-shadow: none;" 
                                       value="R$ 0,00" /> 
                            </div>
                        </fieldset>
                        <fieldset class="grupo" style="border: solid 1px gray; padding: 3px;">
                            <div class="campo">
                                <label for="cpImp">5. Impostos</label>
                                <input type="text" id="cpImp" name="cpImp"  readonly="true"
                                       style="width: 10em;border: none;box-shadow: none;" 
                                       value="R$ 0,00" /> 
                            </div>
                        </fieldset>
                        <fieldset class="grupo" style="border: solid 1px gray; padding: 3px;">
                            <div class="campo">
                                <label for="cpRend" id="lblAliq">
                                    Alíquota efetiva - % 0,00 Percentual do imposto sobre os rendimentos tributáveis.
                                </label>
                            </div>
                        </fieldset>
                        <fieldset class="grupo" style="border: solid 1px gray; padding: 3px;">
                            <div class="campo">
                            </div>
                            <button type="submit" class="botao" name="submit">Confirmar</button>
                        </fieldset>
                    </fieldset>
                </form>

            </div>

        </div>

        <div class="col span_2_of_5">
            <h4>Tabela de Cálculos</h4>
            <table id="playlistTable">
                <!--<caption>Top 15 Playlist</caption>-->
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Nome</th>
                        <th>Rendimento</th>
                        <th>Deduções</th>
                        <th>Imposto</th>
                        <th>Parcelas</th>
                        <th>Aliquota</th>
                    </tr>
                </thead>
                <c:forEach items="${requestScope.lista}" var="c">
                    ${c.toString()}
                </c:forEach>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $("#cpRend").maskMoney({prefix: 'R$ ', allowZero: true, thousands: '.', decimal: ',', affixesStay: true});
        $("#cpContri").maskMoney({prefix: 'R$ ', allowZero: true, thousands: '.', decimal: ',', affixesStay: true});
        $("#cpPensao").maskMoney({prefix: 'R$ ', allowZero: true, thousands: '.', decimal: ',', affixesStay: true});
        $("#cpMedico").maskMoney({prefix: 'R$ ', allowZero: true, thousands: '.', decimal: ',', affixesStay: true});
        $("#cpEducacao").maskMoney({prefix: 'R$ ', allowZero: true, thousands: '.', decimal: ',', affixesStay: true});
        $("#cpOutras").maskMoney({prefix: 'R$ ', allowZero: true, thousands: '.', decimal: ',', affixesStay: true});
// $("#cpRend").maskMoney({prefix:'R$ ', thousands:'.', decimal:',', affixesStay: true}});
// $("#cpContri").maskMoney({symbol:'R$ ',showSymbol:true, thousands:'.', decimal:',', symbolStay: true});

        $(".ded").change(function () {
            $.get('irrf?op=ajaxDeducoes',
                    {contribuicao: $("#cpContri").val(), dependentes: $("#cpDepend").val(),
                    pensao: $("#cpPensao").val(), medico: $("#cpMedico").val(), 
                    educacao: $("#cpEducacao").val(), outros: $("#cpOutras").val()},
                    function (result) {
                        $('#cpDeducoes').val(result);
                    });
        });

        $(".bc").change(function () {
            $.get('irrf?op=ajaxBaseCalculo',
                    {rendimento: $("#cpRend").val(), contribuicao: $("#cpContri").val(), 
                    dependentes: $("#cpDepend").val(),
                    pensao: $("#cpPensao").val(), medico: $("#cpMedico").val(), 
                    educacao: $("#cpEducacao").val(), outros: $("#cpOutras").val()},
                    function (result) {
                        $('#cpBase').val(result);
                    });
        });

        $(".imp").change(function () {
            $.get('irrf?op=ajaxImposto',
                    {rendimento: $("#cpRend").val(), contribuicao: $("#cpContri").val(), 
                    dependentes: $("#cpDepend").val(),
                    pensao: $("#cpPensao").val(), medico: $("#cpMedico").val(), 
                    educacao: $("#cpEducacao").val(), outros: $("#cpOutras").val()},
                    function (result) {
                        //alert(result);
                        var json_obj = $.parseJSON(result);
                        //alert("js "+json_obj);
                        $('#cpImp').val(json_obj.imposto);
                        $('#lblAliq').html(json_obj.perc);
                    });
        });

    })
</script>
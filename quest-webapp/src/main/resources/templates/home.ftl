<!DOCTYPE html>

<#import "lib/utils.ftl" as u>

<@u.page>
    <#function background value>
      <#if value>
        <#return "white" />
      <#else>
        <#return "#474040" />
      </#if>
    </#function>
    <#function font value>
      <#if value>
        <#return "black" />
      <#else>
        <#return "white" />
      </#if>
    </#function>
    <center>
        92 Club : ${ninetyTwoClubTotal}

        <#list divisions as division>
            <table width=75%>
                <tr>
                    <th style="border: 1px solid black; border-spacing: 15px; text-align:center;">${division.name}</td>
                </tr>
            </table>
            <#list division.teams as team>
                <table style="border: 1px solid black;" width = 75%>
                    <tr>
                        <td bgcolor=${background(team.visited92Club)} style="border: 1px solid black; text-align:center"><font color=${font(team.visited92Club)}>${team.name}</font></td>
                    </tr>
                </table>
            </#list>
            <br/>
        </#list>

        <!--table style="border-collapse: collapse; border: 1px solid black;">
            <tr>
                <th>Team</th>
                <th>Grade</th>
                <th>P</th>
                <th>W</th>
                <th>D</th>
                <th>L</th>
                <th>F</th>
                <th>A</th>
                <th>GD</th>
                <th>Honours</th>
             </tr>
            <#list seasons as season>
                <tr style="background-color:#${season.grade.color}">
                    <td style="text-align:center"><a href="season/${season.number}">${season.number}</a></td>
                    <td style="text-align:center">${season.grade}</td>
                    <td width="50" style="text-align:center">${season.numGames}</td>
                    <td width="50" style="text-align:center">${season.wins}</td>
                    <td width="50" style="text-align:center">${season.draws}</td>
                    <td width="50" style="text-align:center">${season.losses}</td>
                    <td width="50" style="text-align:center">${season.goalsFor}</td>
                    <td width="50" style="text-align:center">${season.goalsAgainst}</td>
                    <td width="50" style="text-align:center">${season.goalDifference}</td>
                    <td style="text-align:center">${season.honours}</td>
                </tr>
            </#list>
        <table-->


    </center>
</@u.page>
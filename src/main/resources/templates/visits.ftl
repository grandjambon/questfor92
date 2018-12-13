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
        <table width=75%>
            <tr>
                <td style="text-align:center; font-size:80px" bgcolor="white">92 Club : ${ninetyTwoClubTotal}/92</td>
            </tr>
        </table>

        <br/>
        <br/>

        <#list visits as team>
            <table style="border: 1px solid black;" width = 90%>
                <tr>
                    <#if team.visited92Club>
                        <td bgcolor="white" style="border: 1px solid black" width=50%><font color="black">${team.name}</font></td>
                        <td bgcolor="white" width=10% align="center"><font color="black">${team.visit.date}</font></td>
                        <td bgcolor="white" width=17% align="right"><font color="black">${team.visit.homeTeam}</font></td>
                        <td bgcolor="white" width=2% align="right"><font color="black">${team.visit.homeGoals}</font></td>
                        <td bgcolor="white" width=2% align="center"><font color="black"> v </font></td>
                        <td bgcolor="white" width=2% align="left"><font color="black">${team.visit.awayGoals}</font></td>
                        <td bgcolor="white" width=17% align="left"><font color="black">${team.visit.awayTeam}</font></td>
                    <#else>
                        <td bgcolor="#474040" style="border: 1px solid black"><font color="white">${team.name}</font></td>
                    </#if>
                </tr>
            </table>
        </#list>
    </center>
</@u.page>